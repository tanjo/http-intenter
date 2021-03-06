package in.tanjo.httpintenter.model.license;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import in.tanjo.httpintenter.R;
import in.tanjo.httpintenter.util.StringUtils;

public class License {

  /**
   * ライセンスの対象ライブラリ
   */
  @NonNull
  public Library library;

  /**
   * ライセンスの保有者
   */
  @NonNull
  public Author owner;

  /**
   * ライセンスの種類
   */
  @NonNull
  public Type type;

  /**
   * ライセンスの日付
   */
  @NonNull
  public String year;

  private License(@NonNull Library library, @NonNull Author owner, @NonNull Type type, @NonNull String year) {
    this.library = library;
    this.owner = owner;
    this.type = type;
    this.year = year;
  }

  public String getCopyRight() {
    return "Copyright " + year + " " + owner.name;
  }

  public enum Type {
    APACHE_2_0(R.string.apach_2_0_name, R.string.apach_2_0_text),
    NO_LICENSE(R.string.no_license_name, R.string.no_license_text),
    MECAB_IPADIC_NOTICE(R.string.mecab_ipadic_2_7_0_notice_name, R.string.mecab_ipadic_2_7_0_notice_text);

    @StringRes
    private int name;

    @StringRes
    private int description;

    Type(@StringRes int name, @StringRes int description) {
      this.name = name;
      this.description = description;
    }

    @StringRes
    public int getName() {
      return name;
    }

    @StringRes
    public int getDescription() {
      return description;
    }
  }

  public static class Builder {

    private Library library = new Library();

    private Author owner = new Author();

    private Type type;

    private String year;

    public Builder() {
      type = Type.NO_LICENSE;
    }

    public Builder type(@NonNull Type type) {
      this.type = type;
      return this;
    }

    public Builder year(@NonNull String year) {
      this.year = year;
      return this;
    }

    public Builder libraryName(@NonNull String name) {
      this.library.name = name;
      return this;
    }

    public Builder libraryUrl(@NonNull String url) {
      this.library.url = url;
      return this;
    }

    public Builder libraryDescription(@NonNull String description) {
      this.library.description = description;
      return this;
    }

    public Builder ownerName(@NonNull String name) {
      this.owner.name = name;
      return this;
    }

    public Builder ownerUrl(@NonNull String url) {
      this.owner.url = url;
      return this;
    }

    public License create() {
      return new License(library, owner, type, StringUtils.nullToEmpty(year));
    }
  }
}
