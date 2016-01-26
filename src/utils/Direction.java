package utils;

import java.awt.Point;

public enum Direction {

	NORD, NORD_OUEST, NORD_EST, EST, OUEST, SUD_OUEST, SUD_EST, SUD;


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
