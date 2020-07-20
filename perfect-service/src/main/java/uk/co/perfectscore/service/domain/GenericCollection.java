package uk.co.perfectscore.service.domain;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * Support for providing generic functionality for collections.
 * 
 * @author Chris Reason
 * @version 1.0
 *
 * @param <T> Generic type that will be overridden/implemented when the concrete class is
 *        instantiated.
 */
@Slf4j
public abstract class GenericCollection<T> {

   protected List<T> collection;
  
  private boolean loaded     = false; // Data was loaded successfully
  private String  message    = "";    // Message outcome
  private int     arrayLimit = 0;     // Upper collection limit
  private int     cursor     = 0;     // Current traversing position

  public List<T> getCollection() {
     return collection;
  }

  public void setCollection(final List<T> collection) {
     this.collection = collection;

     if (collection.size() > 0) {
        setLoaded(true);
     }

     setArrayLimit(collection.size() - 1);
     setCursor(0);

     if (log.isTraceEnabled()) {
        for (T l : collection) {
           log.trace("Week Collection Load [{}]", l.toString());
        }
     }
  }

  public int getArrayLimit() {
     return arrayLimit;
  }

  public void setArrayLimit(final int arrayLimit) {
     this.arrayLimit = arrayLimit;
  }

  public int getCursor() {
     return cursor;
  }

  public void setCursor(final int cursor) {
     this.cursor = cursor;
  }

  public void setLoaded(final boolean loaded) {
     this.loaded = loaded;
  }

  public boolean isLoaded() {
     return loaded;
  }

  public final void setMessage(final String message) {
     this.message = message;
  }

  public final String getMessage() {
     return message;
  }

  public void resetCursor() {
     setCursor(0);
  }

  /**
   * Check if there are more items in the list.
   * 
   * @return True if there is a next item (when traversing the list).
   */
  public boolean hasNext() {
     return cursor <= arrayLimit;
  }

  protected abstract T getInstance();

  /**
   * Allows the structure list to be traversed sequentially.
   *
   * @return The next item from the list or null if no more.
   */
  public T getNext() {

     // Create a new item to return
     T nextElement = getInstance();

     // Check if there are any more items from the list
     if (cursor <= arrayLimit) {
        nextElement = collection.get(cursor);
        cursor++;
     } else {
        // There are no more items - set to null
        nextElement = null;
     }

     // Return the derived item (will be null if not found)
     return nextElement;
  }

  public T get(final int i) {
     return collection.get(i);
  }
}
