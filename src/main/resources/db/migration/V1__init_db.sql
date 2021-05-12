CREATE SEQUENCE users_id_seq;
CREATE SEQUENCE records_id_seq;
CREATE SEQUENCE folder_records_id_seq;

CREATE TABLE "users" (
	"id" bigint NOT NULL,
	"user_name" varchar(100) NOT NULL,
	"avatar" varchar(400) NOT NULL,
	"email" varchar(100) NOT NULL,
	"password" varchar(400) NOT NULL,
	"confirm_email" BOOLEAN NOT NULL,
	"token" varchar(400) NOT NULL,
	"phone_number" varchar(15),
	"create_date" TIMESTAMP NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY ("id")
);

CREATE TABLE "folder_records" (
	"id" bigint NOT NULL,
	"name_folder" varchar(50) NOT NULL,
	"create_date" TIMESTAMP NOT NULL,
	CONSTRAINT folder_records_pk PRIMARY KEY ("id")
);

CREATE TABLE "records" (
	"id" bigint NOT NULL,
	"user_id" bigint  NOT NULL,
	"folder_id" bigint  NOT NULL,
	"status" BOOLEAN NOT NULL,
	"name_record" varchar(50) NOT NULL,
	"password_record" varchar(100) NOT NULL,
	"link" varchar(200) NOT NULL,
	"notes" TEXT NOT NULL,
	"phone_number" varchar(15),
	"create_date" TIMESTAMP NOT NULL,
	CONSTRAINT records_pk PRIMARY KEY ("id")
);

ALTER SEQUENCE users_id_seq OWNED BY users.id;
ALTER SEQUENCE folder_records_id_seq OWNED BY folder_records.id;
ALTER SEQUENCE records_id_seq OWNED BY records.id;

alter table "records" add CONSTRAINT "records_fk0" FOREIGN KEY ("user_id") REFERENCES "users"("id");
alter table "records" add CONSTRAINT "records_fk1" FOREIGN KEY ("folder_id") REFERENCES "folder_records"("id");

ALTER TABLE public.users ALTER COLUMN id SET DEFAULT nextval('users_id_seq');
ALTER TABLE public.folder_records ALTER COLUMN id SET DEFAULT nextval('folder_records_id_seq');
ALTER TABLE public.records ALTER COLUMN id SET DEFAULT nextval('records_id_seq');


