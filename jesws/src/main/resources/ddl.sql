create table person
(
  id         int identity
    primary key,
  first_name varchar(100),
  last_name  varchar(100),
  email      varchar(100),
  active     int
)
go


CREATE PROCEDURE SP_PERSON_ALL_SL
AS
  SELECT *
  FROM person;
  ;
go

CREATE PROCEDURE SP_PERSON_ID_SL(@id as varchar(10))
AS
  begin
    SELECT * FROM person p where p.id = @id;
  end;
go

CREATE PROCEDURE SP_PERSON_DL(@id as INT)
AS
  begin
    DELETE FROM JES.dbo.person where id = @id;
  end;
go

CREATE PROCEDURE SP_PERSON_BYID_SL(@id as INT)
AS
  begin
    SELECT * FROM person where id = @id;
  end;
go

CREATE PROCEDURE SP_PERSON_IN(@firstName as varchar(50), @lastName as varchar(50), @mail as varchar(50), @active as int)
AS
  begin
    insert into person values (@firstName, @lastName, @mail, @active);
  end;
go

CREATE PROCEDURE SP_PERSON_UP(@id as     INT, @firstName as varchar(50), @lastName as varchar(50), @mail as varchar(50),
                              @active as int)
AS
  begin
    update JES.dbo.person
    set first_name = @firstName,
        last_name  = @lastName,
        email      = @mail,
        active     = @active
    where id = @id;
  end;
go

