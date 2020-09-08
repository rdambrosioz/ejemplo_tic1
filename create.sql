
    create table person (
       id bigint not null,
        first_name varchar(50),
        last_name varchar(50),
        primary key (id)
    ) engine=InnoDB;

    create table vehicle (
       plate varchar(8) not null,
        brand varchar(20),
        estimated_price bigint,
        model varchar(20),
        year integer,
        primary key (plate)
    ) engine=InnoDB;

    create table vehicle_owner (
       vehicle_plate varchar(8) not null,
        owner_id bigint not null,
        primary key (vehicle_plate, owner_id)
    ) engine=InnoDB;

    alter table vehicle_owner 
       add constraint fk_vehicle_owner_person
       foreign key (owner_id) 
       references person (id);

    alter table vehicle_owner 
       add constraint fk_vehicle_owner_vehicle
       foreign key (vehicle_plate) 
       references vehicle (plate);

