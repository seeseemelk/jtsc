/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package be.seeseemelk.jtsc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

import be.seeseemelk.jtsc.recompiler.Recompiler;

public class App
{

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		var recompiler = new Recompiler(Paths.get("input/TestApp.class"), Paths.get("output"));
		recompiler.recompile();
	}
}
