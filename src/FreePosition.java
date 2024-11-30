class FreePosition{
    private int r;
    private int c;
    private Casella g[][];
    
    FreePosition(int r, int c){
        this.r = r;
        this.c = c;
    }
    
    FreePosition(Casella g[][], int r, int c){
        this.g = g;
        this.r = r;
        this.c = c;
    }
    
    
    /*private Casella getCasella(){
        return g[][];
    }*/
    
    public int getRiga(){
        return r;
    }
    
    public int getColonna(){
        return c;
    }
}
