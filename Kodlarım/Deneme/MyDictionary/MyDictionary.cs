using System;
using System.Collections.Generic;
using System.Text;

namespace MyDictionary
{
    public class MyDictionary<T1, T2>
    {
        T1[] _keys;
        T2[] _values;

        public MyDictionary()
        {
            _keys = new T1[0];
            _values = new T2[0];
        }

        public void Add(T1 key, T2 value)
        {
            T1[] tempKeys = _keys;
            T2[] tempvalues = _values;

            _keys = new T1[_keys.Length + 1];
            _values = new T2[_values.Length + 1];

            for (int i = 0; i < tempKeys.Length; i++)
            {
                _keys[i] = tempKeys[i];
            }
            for (int j = 0; j < tempvalues.Length; j++)
            {
                _values[j] = tempvalues[j];
            }
            _keys[_keys.Length - 1] = key;
            _values[_values.Length - 1] = value;
        }
        public int Count
        {
            get { return _keys.Length; }
        }
    }
}
