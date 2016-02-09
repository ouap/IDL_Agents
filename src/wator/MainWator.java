package wator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import View.View;
import hunter.GameOverException;

public class MainWator {

	public static void main(String[] args) throws InterruptedException, IOException, GameOverException {

		if (args.length != 13) {
			Path path = Paths.get("err_wator.err");
			try (Stream<String> lines = Files.lines(path)) {
				lines.forEach(s -> System.out.println(s));
			} catch (IOException ex) {
				System.exit(1);
			}
		}else{
			SMAWator simulation = new SMAWator(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), Boolean.valueOf(args[5]), Boolean.valueOf(args[6]), Boolean.valueOf(args[7]), Integer.parseInt(args[8]), Integer.parseInt(args[9]), Integer.parseInt(args[10]), Integer.parseInt(args[11]), Integer.parseInt(args[12]));
			View v = new GraphicViewWator(simulation, "Chambre d'evolution");
			v.setVisible(true);
			simulation.run();
		}

	}
}
