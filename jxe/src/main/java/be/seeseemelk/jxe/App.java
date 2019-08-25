/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package be.seeseemelk.jxe;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import be.seeseemelk.jxe.discovery.Library;
import be.seeseemelk.jxe.rules.PureRule;
import be.seeseemelk.jxe.rules.RuleCheckerMethodException;

public class App
{
	private static Library discover(Path input) throws IOException
	{
		var library = new Library();
		library.discover(input);
		return library;
	}
	
	private static void performChecks(Library library) throws IOException
	{
		var rule = new PureRule();
		
		try
		{
			library.check(rule);
		}
		catch (RuleCheckerMethodException e)
		{
			System.err.format("%n%n");
			System.err.format("%sOops, the code did not validate correctly.%n", ANSI.RED);
			System.err.format("Location: %s%n", e.getPosition());
			System.err.format("%s%s%n%n", e.getMessage(), ANSI.RESET);
			
			if (e.getLongDescription().isPresent())
			{
				String description = e.getLongDescription().get();
				System.err.format("%s%n", description);
			}
			
			System.err.println();
		}
	}
	
	public static void recompile(Path input) throws IOException
	{
		var library = discover(input);
		performChecks(library);
		//var recompiler = new Recompiler(input, Paths.get("../output"));
		//recompiler.recompile();
	}

	public static void main(String[] args) throws IOException
	{
		if (args.length > 0)
		{
			for (var arg : args)
				recompile(Paths.get(arg));
		}
		else
		{
			recompile(Paths.get("../input_class"));
		}
	}
}
