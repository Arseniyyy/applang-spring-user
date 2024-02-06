CREATE TABLE u
(
    id UUID PRIMARY KEY,
    email VARCHAR UNIQUE NOT NULL,
    nickname VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR UNIQUE NOT NULL,
    date_of_birth DATE NOT NULL,
    native_language VARCHAR NOT NULL,
    subscription VARCHAR NOT NULL,
    registrationMethod VARCHAR NOT NULL,
    enabled BOOLEAN NOT NULL,
    verificationCode VARCHAR(6) NOT NULL,
    words UUID[]
);

CREATE TABLE u_authority
(
  id          UUID PRIMARY KEY,
  id_u        UUID NOT NULL REFERENCES u,
  c_authority VARCHAR NOT NULL
);

CREATE TABLE deactivated_token
(
  id            UUID PRIMARY KEY,
  c_keep_until  TIMESTAMP NOT NULL CHECK ( c_keep_until > now() )
);
