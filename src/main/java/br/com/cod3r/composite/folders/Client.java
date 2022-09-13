package br.com.cod3r.composite.folders;

import br.com.cod3r.composite.folders.model.CompositeFile;
import br.com.cod3r.composite.folders.model.CompositeFolder;
import br.com.cod3r.composite.folders.model.FileSystemItem;
import java.io.File;
import java.util.ArrayList;

public class Client {


	public static FileSystemItem createCompositeFromFile(File file) {
		if (!file.isDirectory()) return new CompositeFile(file.getName());

		final ArrayList<FileSystemItem> children = new ArrayList<>();
		final File[] files = file.listFiles();

		for (File javaFile: files) {
			children.add(createCompositeFromFile(javaFile));
		}

		return new CompositeFolder(file.getName(), children);
	}

	public static void main(String[] args) {
		final String dir = System.getProperty("user.dir");
		final FileSystemItem fromDisk = createCompositeFromFile(new File(dir + File.separator));
		fromDisk.print("");
	}
}
