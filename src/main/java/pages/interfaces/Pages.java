package pages.interfaces;

public interface Pages<T extends Pages<T>> {
    T initPage();
}
