package br.com.cod3r.bridge.converter;

import br.com.cod3r.bridge.converter.converters.CSVConverter;
import br.com.cod3r.bridge.converter.converters.Converter;
import br.com.cod3r.bridge.converter.converters.JsonConverter;
import br.com.cod3r.bridge.converter.employees.ITGuy;
import br.com.cod3r.bridge.converter.employees.ProjectManager;

public class Client {

	public static void main(String[] args) {
		final Converter csvConverter = new CSVConverter();
		final Converter jsonConverter = new JsonConverter();

		final ITGuy itGuy = new ITGuy("Joe", 20, 4000d);
		final ProjectManager projectManager = new ProjectManager("Bob", 30, 6000d);

		System.out.println(csvConverter.getEmployeeFormated(itGuy));
		System.out.println(jsonConverter.getEmployeeFormated(itGuy));

		System.out.println("-----###-----");

		System.out.println(csvConverter.getEmployeeFormated(projectManager));
		System.out.println(jsonConverter.getEmployeeFormated(projectManager));
	}
}
