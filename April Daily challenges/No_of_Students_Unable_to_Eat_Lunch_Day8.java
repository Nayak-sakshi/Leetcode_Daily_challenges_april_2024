public class No_of_Students_Unable_to_Eat_Lunch_Day8 {
    public static void main(String[] args) {
        int[] students = {1, 1, 1, 0, 0};
        int[] sandwiches = {0, 1, 1, 1, 0};
        Solution solution = new Solution();
        int remainingStudents = solution.countStudents(students, sandwiches);
        System.out.println("Remaining students: " + remainingStudents);
    }

        public int countStudents(int[] students, int[] sandwiches) {
            int circleSandwich=0;
            int squareSandwich=0;
            for (int choice : students){
                if(choice==0){
                    circleSandwich++;
                }
                else{
                    squareSandwich++;
                }
            }
            for(int sandwich : sandwiches){
                if(sandwich==0 && circleSandwich==0){
                    return squareSandwich;
                }
                if(sandwich==1 && squareSandwich==0){
                    return circleSandwich;
                }
                if(sandwich==0){
                    circleSandwich--;
                }else{
                    squareSandwich--;
                }
            }
            return 0;
        }

}
