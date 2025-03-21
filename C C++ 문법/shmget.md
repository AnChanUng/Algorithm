## shmget
```
int shmget(key_t key, size_t size, int shmflg);
```
- 공유 메모리 세그먼트를 생성하거나 기존 세그먼트에 접근할 때 사용
- key: 식별자로, 특정 공유 메모리 세그먼트를 지정
- size: 생성할 공유 메모리의 크기(바이트 단위)를 지정
- shmflg: 접근 권한 및 생성 옵션(예: IPC_CREAT)을 설정
- 성공 시 공유 메모리 식별자(shmid)를, 실패 시 -1을 반환

## shmctl
```
int shmctl(int shmid, int cmd, struct shmid_ds *buf);
```
- 공유 메모리 세그먼트에 대한 제어 작업을 수행하는 함수
- shmid: shmget을 통해 얻은 공유 메모리 식별자
- cmd: 수행할 제어 명령을 지정하며, 주로 IPC_STAT(상태 조회), IPC_SET(권한 변경), IPC_RMID(제거) 등이 사용
- buf: 명령에 따라 세그먼트 정보(struct shmid_ds)를 저장하거나 설정하는데 사용
- 성공 시 0을, 실패 시 -1을 반환
