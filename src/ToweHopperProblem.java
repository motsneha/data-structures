public class ToweHopperProblem {

    int[] tower = new int[]{4, 2, 0, 0, 2, 0};

    public boolean isHoppable(int[] tower) {

        int current = 0;
        boolean isHoppable = false;
        do {
            current = nextStep(current, tower);
            if(current == -1){

            }
            isHoppable = true;
        }while (current >= tower.length);

        return isHoppable;
    }


    public int nextStep(int index, int[] tower) {
        for (int i = 0; i < tower.length; i++) {

        }
        return -1;
    }
}
