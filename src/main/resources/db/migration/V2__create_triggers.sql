


CREATE OR REPLACE FUNCTION update_average_score()
RETURNS TRIGGER AS $$
BEGIN

    UPDATE catalog_item_entity
    SET average_score = (
        SELECT AVG(rating)
        FROM user_rating_entity
        WHERE catalog_item_id = NEW.catalog_item_id
    )
    WHERE id = NEW.catalog_item_id;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER trg_update_average_score
AFTER INSERT OR UPDATE ON user_rating_entity
FOR EACH ROW
    EXECUTE FUNCTION update_average_score();
