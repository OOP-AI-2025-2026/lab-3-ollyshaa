package org.example.task2;
import java.util.Arrays;

public class Cart {
    private Item[] cartContents;
    private int currentIndex;

    public Cart(Item[] initialContents) {
        this.cartContents = initialContents;
        this.currentIndex = 0;
    }

    public void removeById(int itemIndex) {
        if (this.currentIndex == 0)
            return;
        int foundItemIndex = this.findItemInArray(this.cartContents[itemIndex]);
        if (foundItemIndex == -1)
            return;
        if (foundItemIndex == this.currentIndex - 1) {
            this.cartContents[this.currentIndex - 1] = null;
            this.currentIndex--;
            return;
        }
        this.shiftArray(foundItemIndex);
    }

    private void shiftArray(int itemIndex) {
        for (int i = itemIndex; i < this.currentIndex - 1; i++) {
            this.cartContents[i] = this.cartContents[i + 1];
        }
        this.cartContents[this.currentIndex - 1] = null;
        this.currentIndex--;
    }

    private int findItemInArray(Item targetItem) {
        for (int i = 0; i < this.currentIndex; i++) {
            if (this.cartContents[i].getId() == targetItem.getId()) {
                return i;
            }
        }
        return -1;
    }

    public void add(Item newItem) {
        if (this.isCartFull())
            return;
        this.cartContents[this.currentIndex] = newItem;
        this.currentIndex++;
    }

    private boolean isCartFull() {
        return this.currentIndex == this.cartContents.length;
    }

    public Item[] getContents() {
        return Arrays.copyOf(this.cartContents, this.currentIndex);
    }

    public int getCurrentSize() {
        return this.currentIndex;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "contents=" + Arrays.toString(this.getContents()) +
                '}' + "\n";
    }
}