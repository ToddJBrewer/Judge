public class Judge {

    /**
     *
     * @param N number of people in town
     * @param trust list of which people trust and are trusted by who
     * @return pos of town judge or -1 if none exists
     */
    public static int findJudge(int N, int[][] trust) {
        //arrays which will store who trusts who and who is trusted by who
        int[] trusts = new int[N];
        int[] trustedBy = new int[N];

        //loop through town list and make a list of who trusts and is trusted by
        for (int i = 0; i < trust.length; i++) {
            int truster = trust[i][0];
            int trustee = trust[i][1];
            trusts[truster-1]++;
            trustedBy[trustee-1]++;
        }
        //check if anyone meets judge criteria -- trusts none and is trusted by all but himself
        for (int i = 0; i < N; i++) {
            if (trustedBy[i] == N-1 && trusts[i] == 0) {
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        //test cases
        //number on array indicate judge -- in arr1, person 1 is the judge and so on
        //exception is arrNoJudge1 and 2 which should both return -1
        int[][] arr1 = {{2, 1}, {3, 1}, {4,1}, {2, 3}, {3, 2}};
        int N = 4;
        System.out.println(findJudge(N, arr1));
        int[][] arr2 = {{1, 2}, {3, 2}, {4, 2}, {5, 2}, {6, 2}, {3, 4}, {5, 6}};
        N = 6;
        System.out.println(findJudge(N, arr2));
        int[][] arr3 = {{4, 3}, {1, 2}, {1, 3}, {2, 3}, {5, 1}, {5, 3}, {4, 1}, {4,5}};
        N = 5;
        System.out.println(findJudge(N, arr3));
        int[][] arr4 = {{1, 4}, {2, 4}, {3, 4}, {5, 4}, {6, 4}, {7, 4}, {8, 4}, {3, 1}, {8, 6}, {3, 7}, {1, 6}, {5, 3}};
        N = 8;
        System.out.println(findJudge(N, arr4));
        int[][] arr5 = {{1, 5}, {2, 5}, {3, 5}, {4, 5}, {1, 2}, {1, 3}, {1, 4}, {2, 1}, {2, 3}, {2, 4}, {3, 1}, {3, 2}, {3, 4}, {4, 1}, {4, 2}, {4, 3}};
        N = 5;
        System.out.println(findJudge(N, arr5));
        int[][] arrNoJudge1 = {{4, 3}, {1, 2}, {1, 3}, {2, 3}, {5, 1}, {5, 3}, {4, 1}, {4,5}, {2, 3}};
        N = 5;
        System.out.println(findJudge(N, arrNoJudge1));
        int[][] arrNoJudge2 = {{1, 5}, {2, 5}, {4, 5}, {1, 2}, {1, 3}, {1, 4}, {2, 1}, {2, 3}, {2, 4}, {3, 1}, {3, 2}, {3, 4}, {4, 1}, {4, 2}, {4, 3}};
        N = 5;
        System.out.println(findJudge(N, arrNoJudge2));
    }
}