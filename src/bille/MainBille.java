package bille;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import View.View;
import hunter.GameOverException;

public class MainBille {

	public static void main(String[] args) throws InterruptedException, GameOverException {
		// TODO by Ouamar Sais "Vérifier si ça rend bien" for 09/02/2016
		if (args.length == 1 && args[0].equals("readme")) {
			Path path = Paths.get("readme_bille.md");
			try (Stream<String> lines = Files.lines(path)) {
				lines.forEach(s -> System.out.println(s));
			} catch (IOException ex) {
				System.exit(0);
			}
		}

		else if (args.length != 9) {
			Path path = Paths.get("error_bille.err");
			try (Stream<String> lines = Files.lines(path)) {
				lines.forEach(s -> System.out.println(s));
			} catch (IOException ex) {
				System.exit(1);
			}
		}

		else {
			SMABille simulation = new SMABille(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]),
					Integer.parseInt(args[4]), Integer.parseInt(args[5]), Boolean.valueOf(args[6]), Boolean.valueOf(args[7]), Boolean.valueOf(args[8]));
			View v = new GraphicViewBille(simulation, "Chambre d'evolution");
			v.setVisible(true);
			simulation.run();
		}
	}
}
