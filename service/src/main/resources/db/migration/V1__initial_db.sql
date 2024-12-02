-- Create 'list' table
CREATE TABLE list (
    id SERIAL PRIMARY KEY,           -- Auto-incrementing primary key
    name VARCHAR(255) NOT NULL       -- Name field
);

-- Create 'item' table with foreign key to 'list'
CREATE TABLE item (
    id SERIAL PRIMARY KEY,           -- Auto-incrementing primary key
    name VARCHAR(255) NOT NULL,      -- Name of the item
    checked BOOLEAN DEFAULT FALSE,   -- 'checked' boolean field (defaults to false)
    list_id BIGINT,                  -- Foreign key to 'list'
    CONSTRAINT fk_list FOREIGN KEY (list_id) REFERENCES list(id) ON DELETE CASCADE
);

-- Optionally, add an index on 'list_id' in 'item' table for better performance in joins
CREATE INDEX idx_list_id ON item(list_id);
