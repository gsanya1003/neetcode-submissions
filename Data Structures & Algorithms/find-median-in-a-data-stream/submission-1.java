class MedianFinder {

ArrayList<Integer> arr;
    public MedianFinder() {
        arr = new ArrayList<>();
    }
    
    public void addNum(int num) {
        arr.add(num);
        Collections.sort(arr);
    }
    
    public double findMedian() {
        if(arr.size()%2 == 1)
        return arr.get(arr.size()/2);
        //System.out.println("sjbshbdshsb"+arr.get((arr.size()/2)-1) + "  " + arr.get(arr.size()/2) + " " + double((arr.get((arr.size()/2)-1)       +      arr.get(arr.size()/2)/2)));
       return (arr.get((arr.size() / 2) - 1) + arr.get(arr.size() / 2)) / 2.0;
    }
}
