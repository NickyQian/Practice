package com.practice.forbook;

/**
 * 
 * 有N个人上楼 按下电梯 当电梯只能在停一次 求出电梯停的楼层使得所有人爬的楼梯数目最小
 * if can stop N times ? (open question)
 * @author Nicky
 * 
 */
public class LiftToStop {
	public int[] nPerson = {0,1,2,3}; // nPerson[i] presents the number of passengers going to the ith floor.
	public int totalFloors = nPerson.length - 1;
	public int nMinFloor = -1;    // minimum floors to climb
	public int nTargetFloor = -1; // the floor to stop

	public void searchMinFloor() { // time complexity : O(totalFloors^2)
		for (int i = 1; i <= totalFloors; i++) {
			int nFloor = 0;
			for(int j = 1; j < i; j++){
				nFloor += nPerson[j]*(i-j);
			}
			for(int j = i; j <= totalFloors; j++) {
				nFloor += nPerson[j]*(j-i);
			}
			if(nTargetFloor == -1|| nMinFloor > nFloor) {
				nMinFloor = nFloor;
				nTargetFloor = i;
			}
		}
	}
	
	public void serchMinFloorQuickly() { // time complexity : O(totalFloors)
		//TODO
	}
	
	public static void main(String[] args) {
		LiftToStop lift = new LiftToStop();
		lift.searchMinFloor();
		System.out.println("The lift should stop at " + lift.nTargetFloor + "th floor.");
		System.out.println("Total number of floors to climb: " + lift.nMinFloor + ".");
	}
}
