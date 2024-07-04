import {createStore} from "vuex";

const store = createStore({
    state() {
        return {
            account: {
                id: ""
            }
        }
    },
    mutations: {
        setAccount(state, payload) {
            state.account.id = payload;
        }
    }
})

export default store;
