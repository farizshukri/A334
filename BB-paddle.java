
    public void move() {
        if (moveLeft && x > 0) {
            x -= 5;
        }

        if (moveRight && x < 800 - width) {
            x += 5;
        }
    }