/*-
 * Copyright (C) 2006-2008 Erik Larsson
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.catacombae.hfs.types.carbon;

import org.catacombae.util.Util;
import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;

/** This class was generated by CStructToJavaClass. */
public class Point implements StructElements {
    /*
     * struct Point
     * size: 4 bytes
     * description:
     *
     * BP  Size  Type    Identifier  Description
     * ---------------------------------------------------
     * 0   2     SInt16  v           Vertical coordinate
     * 2   2     SInt16  h           Horizontal coordinate
     */

    public static final int STRUCTSIZE = 4;

    private final byte[] v = new byte[2];
    private final byte[] h = new byte[2];

    public Point(byte[] data, int offset) {
	System.arraycopy(data, offset+0, v, 0, 2);
	System.arraycopy(data, offset+2, h, 0, 2);
    }

    public static int length() { return 4; }

    /** Get the vertical coordinate of the point. */
    public short getV() { return Util.readShortBE(v); }

    /** Get the horizontal coordinate of the point. */
    public short getH() { return Util.readShortBE(h); }

    @Override
    public String toString() { return "(" + getV() + "," + getH() + ")"; }

    public void printFields(PrintStream ps, String prefix) {
	ps.println(prefix + " v: " + getV());
	ps.println(prefix + " h: " + getH());
    }

    public void print(PrintStream ps, String prefix) {
	ps.println(prefix + "Point:");
	printFields(ps, prefix);
    }

    public byte[] getBytes() {
	byte[] result = new byte[STRUCTSIZE];
	int offset = 0;
	System.arraycopy(v, 0, result, offset, v.length); offset += v.length;
	System.arraycopy(h, 0, result, offset, h.length); offset += h.length;
	return result;
    }

    /* @Override */
    public Dictionary getStructElements() {
        DictionaryBuilder db = new DictionaryBuilder(Point.class.getSimpleName());

        db.addUIntBE("v", v);
        db.addUIntBE("h", h);

        return db.getResult();
    }
}
