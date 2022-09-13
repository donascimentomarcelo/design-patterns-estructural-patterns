package br.com.cod3r.composite.folders.model;

public class CompositeFile implements FileSystemItem {

    private String name;

    public CompositeFile(final String name) {
        this.name = name;
    }

    @Override
    public void print(final String structure) {
        System.out.println(structure + name);
    }
}
