package pages.top;

import java.util.ArrayList;

import tbl.info.TblPlayerInfo;
import utility.CommonDefine;
import utility.CommonMethod;

public class Test {
	public static void main(String[] aaa) {
		TblPlayerInfo tbl = new TblPlayerInfo();
		tbl.Set("name", "hahahahahahahaha");
		
//		System.out.println(getNumberReadyBlockOfCannon(8));
		ArrayList<Integer> a = getReadyCannonMouth();
		for(int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
	}
	
	public static ArrayList<Integer> getReadyCannonMouth() {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < CommonDefine.MAX_NUMBER_CANNON; i++) {
			if (i%2==0) {
				arr.add(i+1);
			}
		}
		
		return arr;
	}
	
	
	
	public static boolean isCannonReady(int value) {
//		String cannonName = "cannon" + index;
//		int value = (Integer) tblPlayerBoard.Get(cannonName);
		int a = value & 1 << 1;
		int b = value & 1;
		
		return (a != 0 && b != 0) || (a == 0 && b == 0);
	}
	
	public static void beDamage(int index) {
		int indexBeDamage = CommonMethod.random(CommonDefine.MAX_NUMBER_BLOCK_EACH_CANNON);
		
		String cannonName = "cannon" + index;
		int value = 0;
		
		value = value | 1 << (CommonDefine.MAX_NUMBER_BLOCK_EACH_CANNON + 3);
		
		System.out.println(value);
	}
	
	public static int getNumberReadyBlockOfCannon(int value) {
		int x = value;
		int check = value & 1;
		int count = 0;
		while (((x >> 1) & 1) == check) {
			count++;
			x = x >> 1;
		}
		
		return count;
	}
}
