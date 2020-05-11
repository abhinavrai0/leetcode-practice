class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int matchingColor = image[sr][sc];
        if (matchingColor != newColor) {
            floodFillPixel(image, sr, sc, matchingColor, newColor);
        }
        return image;
        
        
    }
    
    public void floodFillPixel(int[][] image, int sr, int sc, int matchingColor, int newColor) {
        if (sr >=0 && sr < image.length
            && sc >=0 && sc < image[0].length
            && image[sr][sc]==matchingColor) {
            image[sr][sc] = newColor;
            floodFillPixel(image, sr+1, sc, matchingColor, newColor);
            floodFillPixel(image, sr-1, sc, matchingColor, newColor);
            floodFillPixel(image, sr, sc+1, matchingColor, newColor);
            floodFillPixel(image, sr, sc-1, matchingColor, newColor);
        }
    }
}