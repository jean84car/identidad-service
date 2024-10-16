CREATE TABLE IF NOT EXISTS customer (
    id UUID PRIMARY KEY DEFAULT random_uuid(),
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified TIMESTAMP NOT NULL,
    last_login TIMESTAMP,
    token VARCHAR(255),
    is_active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS phone (
    id BIGSERIAL PRIMARY KEY,
    number VARCHAR(15) NOT NULL,
    city_code VARCHAR(10) NOT NULL,
    country_code VARCHAR(10) NOT NULL,
    customer_id UUID REFERENCES identidad.customer(id) ON DELETE CASCADE
);

CREATE UNIQUE INDEX IF NOT EXISTS idx_user_email ON customer(email);

-- secuencia para la gestion de los telefonos
CREATE SEQUENCE IF NOT EXISTS phone_id_seq START WITH 1 INCREMENT BY 1;


