CREATE TABLE public.u (
  id uuid PRIMARY KEY NOT NULL,
  date_of_birth date,
  email character varying(255) UNIQUE,
  enabled boolean NOT NULL DEFAULT FALSE,
  native_language character varying(255),
  nickname character varying(255) UNIQUE,
  password character varying(255),
  registration_method smallint CHECK (registration_method >= 0 AND registration_method <= 2),
  subscription smallint CHECK (subscription >= 0 AND subscription <= 1),
  verification_code character varying(6)
);

CREATE UNIQUE INDEX uk_dmksigv42l1wl836trnrx836w ON public.u(email);

CREATE UNIQUE INDEX uk_pyt7bcsbb6efouobo0j6rebnw ON public.u(nickname);
