package dev.jaqobb.realisticbookshelves.bookshelf;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public class Bookshelf {

	private Location location;
	private int rows;
	private int pages;
	private ItemStack[] contents;

	public Bookshelf(Location location, int rows, int pages, ItemStack[] contents) {
		this.location = location;
		this.rows = rows;
		this.pages = pages;
		this.contents = contents;
	}

	public Location getLocation() {
		return this.location;
	}

	public int getRows() {
		return this.rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPages() {
		return this.pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public ItemStack[] getContents() {
		return this.contents;
	}

	public void setContents(ItemStack[] contents) {
		this.contents = contents;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || this.getClass() != object.getClass()) {
			return false;
		}
		Bookshelf that = (Bookshelf) object;
		return new EqualsBuilder()
			.append(this.rows, that.rows)
			.append(this.pages, that.pages)
			.append(this.location, that.location)
			.append(this.contents, that.contents)
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
			.append(this.location)
			.append(this.rows)
			.append(this.pages)
			.append(this.contents)
			.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("location", this.location)
			.append("rows", this.rows)
			.append("pages", this.pages)
			.append("contents", this.contents)
			.toString();
	}
}
