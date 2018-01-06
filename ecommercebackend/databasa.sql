create table category(
	id Identity,
	name VARCHAR(50),
	description VARCHAR(500),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_caegory_id PRIMARY KEY (id)

);