import http from 'k6/http';
import { check } from 'k6';
import { randomIntBetween } from 'https://jslib.k6.io/k6-utils/1.2.0/index.js';

export default function () {
  const id = randomIntBetween(1, 2000);
  const res = http.get(`${__ENV.PERSONS_URI}/persons/${id}`);
  check(res, {
    'is status 200': (res) => res.status === 200,
    'body size is > 0': (r) => r.body.length > 0,
  });
}