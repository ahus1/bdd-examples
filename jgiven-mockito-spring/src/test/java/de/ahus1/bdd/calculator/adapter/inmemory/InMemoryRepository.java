package de.ahus1.bdd.calculator.adapter.inmemory;

public class InMemoryRepository<T> {
    private T data;

    public void store( T data ) {
        this.data = data;
    }

    public T retrieve() {
        return data;
    }

}
