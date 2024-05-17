-- 01_DDL.sql

-- memberlist 테이블 생성
CREATE TABLE `scott`.`memberlist` (
  `membernum` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `birth` DATETIME NULL DEFAULT now(),
  `age` INT NULL DEFAULT 20,
  `bpoint` INT NULL DEFAULT 0,
  PRIMARY KEY (`membernum`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

select * from memberlist;

-- booklist 테이블 생성
CREATE TABLE `scott`.`booklist` (
  `booknum` INT NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(100) NOT NULL,
  `makeyear` INT NULL,
  `inprice` INT NOT NULL,
  `rentprice` INT NOT NULL,
  `grade` VARCHAR(5) NULL DEFAULT 'all',
  PRIMARY KEY (`booknum`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `scott`.`rentlist` (
  `numseq` INT NOT NULL AUTO_INCREMENT,
  `rentdate` DATETIME NULL DEFAULT now(),
  `bnum` INT NOT NULL,
  `mnum` INT NOT NULL,
  `discount` INT NULL DEFAULT 0,
  PRIMARY KEY (`numseq`),
  INDEX `fk1_idx` (`bnum` ASC) VISIBLE,
  INDEX `fk2_idx` (`mnum` ASC) VISIBLE,
  CONSTRAINT `fk1` FOREIGN KEY (`bnum`) REFERENCES `scott`.`booklist` (`booknum`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`mnum`) REFERENCES `scott`.`memberlist` (`membernum`)
    ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

select * from rentlist;

-- 필드의 수정
alter table `scott`.`memberlist` change column `birth` `birthday` date not null;

-- 필드의 삭제
alter table `scott`.`memberlist` drop column `gender`;

-- 필드의 추가
alter table `scott`.`memberlist` add column `gender` varchar(3) null after `age`;

-- 테이블의 삭제
drop table `rentlist`;


