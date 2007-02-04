/*-
 * Copyright (C) 2006 Erik Larsson
 * 
 * All rights reserved.
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 */

package org.catacombae.hfsexplorer.apm;

import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.Util2;
import java.io.PrintStream;

/** This class was generated by CStructToJavaClass. */
public class DriverDescriptorRecord {
    /*
     * struct DriverDescriptorRecord
     * size: 268 bytes
     * description: 
     * 
     * BP   Size  Type                       Identifier   Description                          
     * ----------------------------------------------------------------------------------------
     * 0    2     UInt16                     sbSig        {device signature}                   
     * 2    2     UInt16                     sbBlkSize    {block size of the device}           
     * 4    4     UInt32                     sbBlkCount   {number of blocks on the device}     
     * 8    2     UInt16                     reserved1    {reserved}                           
     * 10   2     UInt16                     reserved2    {reserved}                           
     * 12   4     UInt32                     reserved3    {reserved}                           
     * 16   2     UInt16                     sbDrvrCount  {number of driver descriptor entries}
     * 18   8     DriverDescriptorEntry      firstEntry   {first driver descriptor entry}      
     * 26   8*30  DriverDescriptorEntry[30]  babab        {additional drivers, if any}         
     * 266  2     UInt16                     reserved4    {reserved}                           
     */
    
    private final byte[] sbSig = new byte[2];
    private final byte[] sbBlkSize = new byte[2];
    private final byte[] sbBlkCount = new byte[4];
    private final byte[] reserved1 = new byte[2];
    private final byte[] reserved2 = new byte[2];
    private final byte[] reserved3 = new byte[4];
    private final byte[] sbDrvrCount = new byte[2];
    private final DriverDescriptorEntry firstEntry;
    private final DriverDescriptorEntry babab;
    private final byte[] reserved4 = new byte[2];
    
    public DriverDescriptorRecord(byte[] data, int offset) {
	System.arraycopy(data, offset+0, sbSig, 0, 2);
	System.arraycopy(data, offset+2, sbBlkSize, 0, 2);
	System.arraycopy(data, offset+4, sbBlkCount, 0, 4);
	System.arraycopy(data, offset+8, reserved1, 0, 2);
	System.arraycopy(data, offset+10, reserved2, 0, 2);
	System.arraycopy(data, offset+12, reserved3, 0, 4);
	System.arraycopy(data, offset+16, sbDrvrCount, 0, 2);
	firstEntry = new DriverDescriptorEntry(data, offset+18);
	babab = new DriverDescriptorEntry(data, offset+26);
	System.arraycopy(data, offset+266, reserved4, 0, 2);
    }
    
    public static int length() { return 268; }
    
    public short getSbSig() { return Util.readShortBE(sbSig); }
    public short getSbBlkSize() { return Util.readShortBE(sbBlkSize); }
    public int getSbBlkCount() { return Util.readIntBE(sbBlkCount); }
    public short getReserved1() { return Util.readShortBE(reserved1); }
    public short getReserved2() { return Util.readShortBE(reserved2); }
    public int getReserved3() { return Util.readIntBE(reserved3); }
    public short getSbDrvrCount() { return Util.readShortBE(sbDrvrCount); }
    public DriverDescriptorEntry getFirstEntry() { return firstEntry; }
    public DriverDescriptorEntry getBabab() { return babab; }
    public short getReserved4() { return Util.readShortBE(reserved4); }
    
    public void printFields(PrintStream ps, String prefix) {
	ps.println(prefix + " sbSig: " + getSbSig());
	ps.println(prefix + " sbBlkSize: " + getSbBlkSize());
	ps.println(prefix + " sbBlkCount: " + getSbBlkCount());
	ps.println(prefix + " reserved1: " + getReserved1());
	ps.println(prefix + " reserved2: " + getReserved2());
	ps.println(prefix + " reserved3: " + getReserved3());
	ps.println(prefix + " sbDrvrCount: " + getSbDrvrCount());
	ps.println(prefix + " firstEntry: ");
	getFirstEntry().print(ps, prefix+"  ");
	ps.println(prefix + " babab: ");
	getBabab().print(ps, prefix+"  ");
	ps.println(prefix + " reserved4: " + getReserved4());
    }
    
    public void print(PrintStream ps, String prefix) {
	ps.println(prefix + "DriverDescriptorRecord:");
	printFields(ps, prefix);
    }
}