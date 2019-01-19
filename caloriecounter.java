public class caloriecounter{
	public static void main(String args[]){
		//System.out.println(args[0]);
		String gender = args[0];
		//System.out.println(gender);
		int height = Integer.parseInt(args[1]);
		int weight = Integer.parseInt(args[2]);
		int age = Integer.parseInt(args[3]);
		String activity = args[4];
		double act = 0.0;
		double EER = 0.0;
		double BMI = 0.0;
		if (gender.toUpperCase() == "MALE"){
			if (activity.toUpperCase() == "SEDENTARY"){
				 act = 1;
			}
			else if (activity.toUpperCase() == "LOW ACTIVITY"){
				 act = 1.11;
			}
			else if (activity.toUpperCase() == "ACTIVITY"){
				 act = 1.26;
			}
			else {
				 act = 1.48;
			}
			EER = (662-(9.53*age)+(act*15.91*weight)+(5.396*height));
			BMI = (weight/(height*height*0.0001));
	}
		else{
			if (activity.toUpperCase() == "SEDENTARY"){
				 act = 1;
			}
			else if (activity.toUpperCase() == "LOW ACTIVITY"){
				 act = 1.12;
			}
			else if (activity.toUpperCase() == "ACTIVITY"){
				 act = 1.27;
			}
			else {
				 act = 1.45;
			}
		    EER = (354-(6.91*age)+( act*9.36*weight )+(7.26*height));
		    BMI = (weight/(height*height*0.0001));
		}
		System.out.println(EER);
		System.out.println(BMI);
	}
}