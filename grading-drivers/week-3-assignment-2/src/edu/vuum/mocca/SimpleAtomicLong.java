package edu.vuum.mocca;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

/**
 * @class SimpleAtomicLong
 *
 * @brief This class implements a subset of the
 *        java.util.concurrent.atomic.AtomicLong class using a
 *        ReentrantReadWriteLock to illustrate how they work.
 */
class SimpleAtomicLong
{
    /**
     * The value that's manipulated atomically via the methods.
     */
    private long mValue;
    
    /**
     * The ReentrantReadWriteLock used to serialize access to mValue.
     */

    // TODO -- you fill in here by replacing the null with an
    // initialization of ReentrantReadWriteLock.
    private final ReentrantReadWriteLock mRWLock = new ReentrantReadWriteLock();


    /**
     * Creates a new SimpleAtomicLong with the given initial value.
     */
    public SimpleAtomicLong(long initialValue)
    {
        // TODO -- you fill in here
    	mValue=initialValue;
    }

    /**
     * @brief Gets the current value.
     * 
     * @returns The current value
     */
    public long get()
    {
        long value;
        
        final Lock r = mRWLock.readLock();
        
        // TODO -- you fill in here
        r.lock();
        try{
        	value = mValue;
        }finally{
        	r.unlock();
        }

        return value;
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the updated value
     */
    public long decrementAndGet()
    {
        long value = 0;
        
        // TODO -- you fill in here
        final Lock w = mRWLock.writeLock();
        w.lock();
        try{
        	mValue--;
            value = mValue;
        }finally{
        	w.unlock();
        }
        
        return value;
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the previous value
     */
    public long getAndIncrement()
    {
        long value = 0;
        
        
        // TODO -- you fill in here
        final Lock w = mRWLock.writeLock();
        w.lock();
        try{
        	value = mValue;
            mValue++;
        }finally{
        	w.unlock();
        }
        
        return value;
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the previous value
     */
    public long getAndDecrement()
    {
        long value = 0;

        // TODO -- you fill in here
        final Lock w = mRWLock.writeLock();
        w.lock();
        try{
        	value = mValue;
            mValue--;
        }finally{
        	w.unlock();
        }

        return value;
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the updated value
     */
    public long incrementAndGet()
    {
        long value = 0;

        // TODO -- you fill in here
        final Lock w = mRWLock.writeLock();
        w.lock();
        try{
        	mValue++;
            value = mValue;
        }finally{
        	w.unlock();
        }

        return value;
    }
}

