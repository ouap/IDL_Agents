package hunter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import View.View;

public class MainPredator {

	public static void main(String[] args) throws InterruptedException, GameOverException {
		if (args.length != 12) {
			Path path = Paths.get("err_hunter.err");
			try (Stream<String> lines = Files.lines(path)) {
				lines.forEach(s -> System.out.println(s));
			} catch (IOException ex) {
				System.exit(0);
			}
		}else{
			// Paramètre vitesse poursuivants
			SMAPredator simulation = new SMAPredator(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), Boolean.valueOf(args[5]), Boolean.valueOf(args[6]), Boolean.valueOf(args[7]), Boolean.valueOf(args[8]), Integer.parseInt(args[9]), Integer.parseInt(args[10]), Integer.parseInt(args[11]));
			View v = new GraphicViewPredator(simulation, "Chambre d'evolution");
			v.setVisible(true);
			simulation.run();
		}


	}
}
