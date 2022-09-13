package br.com.cod3r.composite.folders.model;

import java.util.List;

public class CompositeFolder implements FileSystemItem {
    private String name;
    private List<FileSystemItem> children;

    public CompositeFolder(final String name, final List<FileSystemItem> children) {
        this.name = name;
        this.children = children;
    }

    @Override
    public void print(final String structure) {
        System.out.println(structure + name);
        for (FileSystemItem child: children) {
            child.print(structure + "| ");
        }
    }
}
