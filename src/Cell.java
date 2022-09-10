public class Cell {
    private CellStatus status;

    /**
     * Constructor.
     */
    Cell() {
        status = CellStatus.EMPTY;
    }

    /**
     * Get status.
     */
    public CellStatus getStatus() {
        return status;
    }

    /**
     * Set status.
     */
    public void setStatus(CellStatus status) {
        this.status = status;
    }
}
