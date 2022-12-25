package xsolution.search;

class ShuffleArray {
    int rand(int lower, int higher){
        return lower + (int) (Math.random()*(higher-lower+1));
    }
    int[] shuffle(int[] cards, int i){
        if(i == 0) return cards;
        shuffle(cards, i-1);
        int k = rand(0,i);
        int tmp = cards[k];
        cards[k]  = cards[i];
        cards[i] =tmp;

        return cards;
    }
}
