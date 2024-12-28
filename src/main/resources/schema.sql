create table incident(
    id bigint primary key,
    type char(32),
    title varchar(32),
    description varchar(1024),
    create_user varchar(16),
    create_datetime date,
    update_user varchar(16),
    update_datetime date
);
COMMENT ON table incident IS 'incident table';
COMMENT ON column incident.id IS 'incident id';
COMMENT ON column incident.type IS 'type of incident';
COMMENT ON column incident.title IS 'title of incident';
COMMENT ON column incident.description IS 'description of incident';
COMMENT ON column incident.create_user IS 'create user';
COMMENT ON column incident.create_datetime IS 'create datetime';
COMMENT ON column incident.update_user IS 'update user';
COMMENT ON column incident.update_datetime IS 'update datetime';