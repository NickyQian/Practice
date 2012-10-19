package com.practice.forbook;

/**
 * 
 * 有N个人上楼 按下电梯 当电梯只能在停一次 求出电梯停的楼层使得所有人爬的楼梯数目最小
 * if can stop N times ? (open question)
 * @author Nicky
 * 
 */
public class LiftToStop {
	public int[] nPerson = {0,1,8,5}; // nPerson[i] presents the number of passengers going to the ith floor.
	public int totalFloors = nPerson.length - 1;
	public int nMinFloor = -1;    // minimum floors to climb
	public int nTargetFloor = -1; // the floor to stop

	public void searchMinFloor() { // time complexity : O(n^2) n:totalFloors
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
	
	// if stop at ith floor, the total is Y
	// if stop at (i-1)th floor, the total is Y-N1+(N2+N3). 
	// if stop at (i+1)th floor, the total is Y+N1+N2-N3.
	// N1: go under to ith floor.
	// N2: go to ith floor.
	// N3: go up to ith floor.
	
	public void serchMinFloorQuickly() { // time complexity : O(n) n:totalFloors
		//TODO
		int N1,N2,N3,i;
		nTargetFloor = 1;
		nMinFloor = 0;
		// first for the 1th floor, and count from bottom to top.
		for(N1 = 0, N2 = nPerson[1], N3 = 0, i = 2; i <= totalFloors; i++){
			N3 += nPerson[i];
			nMinFloor += nPerson[i]*(i-1);   //people go to ith floor should climb i-1 floors. 
		}
		for(i = 2; i<= totalFloors; i++) {
			if( N1 + N2 < N3) {
				nTargetFloor = i;
				nMinFloor += (N1+N2-N3);
				N1 += N2;
				N2 = nPerson[i];
				N3 -= nPerson[i];
			}
			else
				break;
		}
	}
	
	public static void main(String[] args) {
		LiftToStop lift = new LiftToStop();
		lift.searchMinFloor();
		System.out.println("The lift should stop at " + lift.nTargetFloor + "th floor.");
		System.out.println("Total number of floors to climb: " + lift.nMinFloor + ".");
		System.out.println("------------------- another quick method -----------------------");
		// reset value.
		lift.nMinFloor = -1;
		lift.nTargetFloor = -1;
		lift.serchMinFloorQuickly();
		System.out.println("The lift should stop at " + lift.nTargetFloor + "th floor.");
		System.out.println("Total number of floors to climb: " + lift.nMinFloor + ".");
	}
}
