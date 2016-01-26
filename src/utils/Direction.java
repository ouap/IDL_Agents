package utils;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public enum Direction {

	NORD, NORD_OUEST, NORD_EST, EST, OUEST, SUD_OUEST, SUD_EST, SUD;
	public static Map<String, Point> pointsDir;

	static{
		pointsDir = new HashMap<String, Point>();
		pointsDir.put("NORD", new Point(0, -1));
		pointsDir.put("SUD", new Point(0, +1));
		pointsDir.put("EST", new Point(+1, 0));
		pointsDir.put("OUEST", new Point(-1, 0));
		pointsDir.put("NORD_EST", new Point(+1, -1));
		pointsDir.put("NORD_OUEST", new Point(-1, -1));
		pointsDir.put("SUD_EST", new Point(+1, +1));
		pointsDir.put("SUD_OUEST", new Point(-1, +1));
	}




	public static Point getPoint(Direction dir){
		switch (dir) {

		case NORD:
			return new Point(0, -1);
		case SUD:
			return new Point(0, +1);
		case EST:
			return new Point(+1, 0);
		case OUEST:
			return new Point(-1, 0);
		case NORD_EST:
			return new Point(+1, -1);
		case NORD_OUEST:
			return new Point(-1, -1);
		case SUD_EST:
			return new Point(+1, +1);
		case SUD_OUEST:
			return new Point(-1, +1);
		}

		return null;
	}
}
