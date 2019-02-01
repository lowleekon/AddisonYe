class Rec {
    int FibSeq(int n) {
        if (n <= 1){return n;}
        return  FibSeq(n - 1) + FibSeq(n - 2);
    }
}
