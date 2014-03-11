package arbitre;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import campionat.Participant;
import jugadors.Jugable;

public class Instanciador {
	private static List<Class> getClassesForPackage(Package pkg) {
		String pkgname = pkg.getName();

		List<Class> classes = new ArrayList<Class>();

		// Get a File object for the package
		File directory = null;
		String fullPath;
		String relPath = pkgname.replace('.', '/');

		// System.out.println("ClassDiscovery: Package: " + pkgname +
		// " becomes Path:" + relPath);

		URL resource = ClassLoader.getSystemClassLoader().getResource(relPath);

		// System.out.println("ClassDiscovery: Resource = " + resource);
		if (resource == null) {
			throw new RuntimeException("No resource for " + relPath);
		}
		fullPath = resource.getFile();
		// System.out.println("ClassDiscovery: FullPath = " + resource);

		try {
			directory = new File(resource.toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(
					pkgname
							+ " ("
							+ resource
							+ ") does not appear to be a valid URL / URI.  Strange, since we got it from the system...",
					e);
		} catch (IllegalArgumentException e) {
			directory = null;
		}
		// System.out.println("ClassDiscovery: Directory = " + directory);

		if (directory != null && directory.exists()) {

			// Get the list of the files contained in the package
			String[] files = directory.list();
			for (int i = 0; i < files.length; i++) {

				// we are only interested in .class files
				if (files[i].endsWith(".class")) {

					// removes the .class extension
					String className = pkgname + '.'
							+ files[i].substring(0, files[i].length() - 6);

					// System.out.println("ClassDiscovery: className = " +
					// className);

					try {
						classes.add(Class.forName(className));
					} catch (ClassNotFoundException e) {
						throw new RuntimeException(
								"ClassNotFoundException loading " + className);
					}
				}
			}
		} else {
			try {
				String jarPath = fullPath.replaceFirst("[.]jar[!].*", ".jar")
						.replaceFirst("file:", "");
				JarFile jarFile = new JarFile(jarPath);
				Enumeration<JarEntry> entries = jarFile.entries();
				while (entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					String entryName = entry.getName();
					if (entryName.startsWith(relPath)
							&& entryName.length() > (relPath.length() + "/"
									.length())) {

						// System.out.println("ClassDiscovery: JarEntry: " +
						// entryName);
						String className = entryName.replace('/', '.')
								.replace('\\', '.').replace(".class", "");

						// System.out.println("ClassDiscovery: className = " +
						// className);
						try {
							classes.add(Class.forName(className));
						} catch (ClassNotFoundException e) {
							throw new RuntimeException(
									"ClassNotFoundException loading "
											+ className);
						}
					}
				}
			} catch (IOException e) {
				throw new RuntimeException(pkgname + " (" + directory
						+ ") does not appear to be a valid package", e);
			}
		}
		return classes;
	}
	
	public static ArrayList<Participant> getJugables(){
		ArrayList<Participant> retornJugables= new ArrayList<Participant>();
		List<Class> classes= getClassesForPackage(Package.getPackage("jugadors"));
		
		for (Class class1 : classes) {
			if (!class1.isInterface()) {
				Class<? extends Jugable> c;
				try {
					c = Class.forName(class1.getName())
							.asSubclass(Jugable.class);
					retornJugables.add(new Participant(c.newInstance()));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		System.out.println(retornJugables.toString());
		return retornJugables;
		
	}

}
