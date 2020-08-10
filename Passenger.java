/*
 * represents an airline passenger
 *
 * we have implemented some methods and constructors.
 * we have left the documentation for you to follow
 * to implement the compareTo and equals methods
 */

//Salam Fazil
//V00935894

public class Passenger implements Comparable<Passenger>{

	private int boardingZone;
	private String name;
	private String passport;
	private Time checkinTime;

	public Passenger(int boardingZone, String name, String passport, Time checkinTime) {
		this.boardingZone = boardingZone;
		this.name = name;
		this.passport = passport;
		this.checkinTime = checkinTime;
	}

	public int getBoardingZone () {
		return boardingZone;
	}

	public void setBoardingZone (int boardingZone) {
		this.boardingZone = boardingZone;
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public String getPassport () {
		return passport;
	}

	public void setPassport (String passport) {
		this.passport = passport;
	}

	public Time getTime () {
		return checkinTime;
	}

	public void setTime (Time checkinTime) {
		this.checkinTime = checkinTime;
	}


	public String toString() {
		return passport + ": " + name;
	}


	/* Method Name: compareTo
	* Purpose: returns the result of comparing this boardingZone and
	*    other boardingZone if they are not equal
	*  if boardingZones are equal, it returns the result of comparing
	*   this checkinTime to other checkinTime
	*
	* Parameters: Passenger other
	*
	* Precondition: other is not null
	*
	* Returns:
	*  a value <0 if this Passenger is before other passenger
	*  a value ==0 if this Passenger is the same as other passenger
	*  a value >0 if this Passenger is after other passenger
	*
	* HINT: the Time class implements compareable too!
	*
	*/
	public int compareTo(Passenger other) {
		if(boardingZone < other.getBoardingZone()){
			return -1;
		}else if (boardingZone > other.getBoardingZone()){
			return 1;
		}else{
			if(checkinTime.compareTo(other.getTime()) < 0){
				return -1;
			}else if(checkinTime.compareTo(other.getTime()) > 0){
				return 1;
			}else {
				return 0;
			}
		}
	}

	/* Method Name: equals
	* Purpose: determines whether the passport of this Passenger
	*      is the same as other Passenger
	*
	* Parameters: Passenger other
	*
	* Precondition: other is not null
	*
	* Returns: true if this Passenger is the same as other, false otherwise
	*/
	public boolean equals(Passenger other) {
		return passport.equals(other.getPassport());
	}
    
    

}

