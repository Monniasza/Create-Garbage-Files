/**
 * 
 */
import java.io.*;
import java.util.*;
/**
 * @author oskar
 *
 */
public class Files {
	private int amount = 2, size = 1024000, FNLength = 8;
	private static final String ab = "abcdefghijklmnopqrstuvwxyz", AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String[] extensions = new String[] {".jpg", ".exe", ".png", ".wav", ".mp3", ".zip", ".rar", ".jar", ".7z", ".docx", ".xlsx", ".pptx"};
	/**
	 * 
	 */
	public Files() {}
	
	public void createFiles() {
		for(int i = 0; i < amount; i++) {
			createFile();
		}
	}
	
	private void createFile() {
		String fn = randomChars(true, FNLength);
		String fe = extensions[(int) (extensions.length * Math.random())];
		File fl = new File(fn + fe);
		try {
			fl.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RandomAccessFile fw;
		try {
			fw = new RandomAccessFile(fl, "rw");
			try {
				for(int i = 0; i < size; i++) {
					fw.writeByte((int) (Math.random() * 256));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private String randomChars(boolean both, int sizer) {
		StringBuilder sb = new StringBuilder();
		String xy;
		for(int i = 0; i < sizer; i++) {
			if(both) {
				xy = (Math.random() < 0.5)?ab:AB;
			}else {
				xy = ab;
			}
			sb.append(xy.charAt((int) (Math.random() * 26)));
		}
		return sb.toString();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getFNLength() {
		return FNLength;
	}

	public void setFNLength(int fNLength) {
		FNLength = fNLength;
	}
}