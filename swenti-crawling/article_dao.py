import pymysql
import error


HOSTNAME = 'localhost'
USER = 'root'
PASSWORD = 'als1tn2!@'
DB = 'swenti'
CHARSET = 'utf8'


def con_db():
    return pymysql.connect(host=HOSTNAME, user=USER, password=PASSWORD, db=DB, charset=CHARSET)

# 중복된 기사는 배제  (기준: 기사 제목, 언론사)
def check_duplicate_article(title, writer):
    try:
        conn = con_db()
        cur = conn.cursor()
        cur.execute("SELECT COUNT(*) FROM article WHERE title = %s AND writer = %s", (title, writer))
        # result 값이 Tuple 형태(0,)로 나오기 때문에 숫자 결과 값을 받아오기 위해 인덱스를 표기한다.
        result = cur.fetchone()[0]
        return result
    # db connection error 발생 시
    except Exception as err:
        print("[Error]:" + str(err))
    finally:
        # connection 종료
        conn.close()

def insert_article(title, details, link, media, writer, writed_date, image, site):
    # try:
    print(writed_date)
    conn = con_db()
    cur = conn.cursor()
    # 중복된 기사 확인
    isDuplicated = check_duplicate_article(title, writer)
    if isDuplicated > 0:
        raise error.Error("중복된 기사가 존재 합니다.")
    cur.execute("INSERT INTO article (title, details, link, media, images, writer, writed_date, site ) VALUES (%s, %s, %s, %s, %s, %s, %s, %s)", (title, details, link, media, image, writer, writed_date, site))
    # 반영한 데이터 commit
    conn.commit()
    conn.close()
    # db connection error 발생 시
    # except Exception as err:
    #     print("[Error]" + str(err))
    # finally:
        # connection 종료

